import datetime, time
import threading
from realtimeastronomy.calculator import calculateData, calculateJupiterPert, calculateSaturnPert, calculateUranusPert
from realtimeastronomy import planets
import math


def rev(angle):
    while(angle <= 0 or angle >= 360):
        if(angle < 0):
            angle += 360
        else:
            angle -= 360
    return angle

def calc():
    # calculating UT and d
    currentDT = datetime.datetime.now()
    UT = currentDT.hour + (currentDT.minute / 60.0) + (currentDT.second / 3600)
    year = currentDT.year
    month = currentDT.month
    day = currentDT.day

    # get day zero of J2000 cut off. Assume that it was on December 31, 1999 at 17:00 hours
    d_0 = 367 * 1999 - (7 * (1999 + ((12 + 9) / 12))) / 4 - (3 * ((1999 + (12 - 9) / 7) / 100 + 1)) / 4 + (275 * 12) / 9 + 29.50 - 730515

    #d = 367 * year - (7 * (year + ((month + 9) / 12))) / 4 - (3 * ((year + (month - 9) / 7) / 100 + 1)) / 4 + (275 * month) / 9 + day - 730515
    d = 367 * year - (7 * (year + ((month + 9) / 12))) / 4  + (275 * month) / 9 + day - 730530
    
    # add cut off to compensate for the assumed start of J2000. This will give more accurate readings.
    d += UT/24 + (-1 * d_0) / 10

    currentTimeMills = int(round(time.time()) * 1000)
    millsSince2000 = datetime.datetime(2000, 1, 1).timestamp() * 1000
    millsSince2000 =  946684800000

    d= round((1.0 + (currentTimeMills - millsSince2000) / (3600 * 24.0 * 1000)), 5)
    #d = 7304.50082808
    # mercury calculations
    new_mercury = planets.Mercury()

    N_mercury = rev(new_mercury.N + new_mercury.N_ * d)
    i_mercury = new_mercury.i + new_mercury.i_ * d
    w_mercury = rev(new_mercury.w + new_mercury.w_ * d)
    a_mercury = new_mercury.a
    e_mercury = new_mercury.e + new_mercury.e_ * d
    M_mercury = rev(new_mercury.M + new_mercury.M_ * d)

    mercury_values = calculateData(N_mercury, i_mercury, w_mercury, a_mercury, e_mercury, M_mercury)
    
    print(mercury_values[4])

    # venus calculations
    new_venus = planets.Venus()

    N_venus = rev(new_venus.N + new_venus.N_ * d)
    i_venus = new_venus.i + new_venus.i_ * d
    w_venus = rev(new_venus.w + new_venus.w_ * d)
    a_venus = new_venus.a
    e_venus = new_venus.e - new_venus.e_ * d
    M_venus = rev(new_venus.M + new_venus.M_ * d)

    venus_values = calculateData(N_venus, i_venus, w_venus, a_venus, e_venus, M_venus)

    # mars calculations
    new_Mars = planets.Mars()

    N_mars = new_Mars.N + new_Mars.N_ * d
    i_mars = new_Mars.i - new_Mars.i_ * d
    w_mars = new_Mars.w + new_Mars.w_ * d
    a_mars = new_Mars.a
    e_mars = new_Mars.e + new_Mars.e_ * d
    M_mars = new_Mars.M + new_Mars.M_ * d

    mars_values = calculateData(N_mars, i_mars, w_mars, a_mars, e_mars, M_mars)

    # saturn calculations
    new_Saturn = planets.Saturn()

    N_saturn = rev(new_Saturn.N + new_Saturn.N_ * d)
    i_saturn = new_Saturn.i - new_Saturn.i_ * d
    w_saturn = rev(new_Saturn.w + new_Saturn.w_ * d)
    a_saturn = new_Saturn.a
    e_saturn = new_Saturn.e - new_Saturn.e_ * d
    M_saturn = rev(new_Saturn.M + new_Saturn.M_ * d)

    saturn_values = calculateData(N_saturn, i_saturn, w_saturn, a_saturn, e_saturn, M_saturn)

    # jupiter calculations
    new_Jupiter = planets.Jupiter()

    N_jupiter = rev(new_Jupiter.N + new_Jupiter.N_ * d)
    i_jupiter = new_Jupiter.i - new_Jupiter.i_ * d
    w_jupiter = rev(new_Jupiter.w + new_Jupiter.w_ * d)
    a_jupiter = new_Jupiter.a
    e_jupiter = new_Jupiter.e + new_Jupiter.e_ * d
    M_jupiter = rev(new_Jupiter.M + new_Jupiter.M_ * d)

    jupiter_values = calculateData(N_jupiter, i_jupiter, w_jupiter, a_jupiter, e_jupiter, M_jupiter)
    
    # perform perturbations calculations for Jupiter
    correctedJupiterRh = calculateJupiterPert(M_jupiter, M_saturn, jupiter_values[4], jupiter_values[5], jupiter_values[6])

    # perform perturbations calculations for Saturn
    correctedSaturnRh = calculateSaturnPert(M_jupiter, M_saturn, saturn_values[4], saturn_values[5], saturn_values[6])

    # uranus calculations
    new_Uranus = planets.Uranus()

    N_uranus = rev(new_Uranus.N + new_Uranus.N_ * d)
    i_uranus = new_Uranus.i + new_Uranus.i_ * d
    w_uranus = rev(new_Uranus.w + new_Uranus.w_ * d)
    a_uranus = new_Uranus.a - new_Uranus.a_ * d
    e_uranus = new_Uranus.e + new_Uranus.e_ * d
    M_uranus = rev(new_Uranus.M + new_Uranus.M_ * d)

    uranus_values = calculateData(N_uranus, i_uranus, w_uranus, a_uranus, e_uranus, M_uranus)

    # perform perturbations calculations for Uranus
    correctedUranusRh = calculateUranusPert(M_jupiter, M_saturn, M_uranus, uranus_values[4], uranus_values[5], uranus_values[6])

    print("{:,}".format(round(correctedUranusRh)))

    # neptune calculations
    new_Neptune = planets.Neptune()

    N_neptune = rev(new_Neptune.N + new_Neptune.N_ * d)
    i_neptune = new_Neptune.i - new_Neptune.i_ * d
    w_neptune = rev(new_Neptune.w - new_Neptune.w_ * d)
    a_neptune = new_Neptune.a + new_Neptune.a_ * d
    e_neptune = new_Neptune.e + new_Neptune.e_ * d
    M_neptune = rev(new_Neptune.M + new_Neptune.M_ * d)

    neptune_values = calculateData(N_neptune, i_neptune, w_neptune, a_neptune, e_neptune, M_neptune)

    result = [
        [round(mercury_values[3]), round(mercury_values[0], 6), round(mercury_values[1], 6), round(mercury_values[2], 6)], 
        [round(venus_values[3]), round(venus_values[0], 6), round(venus_values[1], 6), round(venus_values[2], 6)],
        [round(mars_values[3]), round(mars_values[0], 6), round(mars_values[1], 6), round(mars_values[2], 6)],
        [round(correctedJupiterRh), round(jupiter_values[0], 6), round(jupiter_values[1], 6), round(jupiter_values[2], 6)],
        [round(correctedSaturnRh), round(saturn_values[0], 6), round(saturn_values[1], 6), round(saturn_values[2], 6)],
        [round(correctedUranusRh), round(uranus_values[0], 6), round(uranus_values[1], 6), round(uranus_values[2], 6)],
        [round(neptune_values[3]), round(neptune_values[0], 6), round(neptune_values[1], 6), round(neptune_values[2], 6)] 
        ] 
    return result
 