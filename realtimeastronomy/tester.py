import datetime, time
import threading
from realtimeastronomy.calculator import calculateData
from realtimeastronomy import planets

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

    d = round((1.0 + (currentTimeMills - millsSince2000) / (3600 * 24.0 * 1000)), 5)
    
    # mars calculations
    new_Mars = planets.Mars()

    N_mars = new_Mars.N + new_Mars.N_ * d
    i_mars = new_Mars.i + new_Mars.i_ * d
    w_mars = new_Mars.w + new_Mars.w_ * d
    a_mars = new_Mars.a
    e_mars = new_Mars.e + new_Mars.e_ * d
    M_mars = new_Mars.M + new_Mars.M_ * d

    mars_values = calculateData(N_mars, i_mars, w_mars, a_mars, e_mars, M_mars)

    # mercury calculations
    new_mercury = planets.Mercury()

    N_mercury = new_mercury.N + new_mercury.N_ * d
    i_mercury = new_mercury.i + new_mercury.i_ * d
    w_mercury = new_mercury.w + new_mercury.w_ * d
    a_mercury = new_mercury.a
    e_mercury = new_mercury.e + new_mercury.e_ * d
    M_mercury = new_mercury.M + new_mercury.M_ * d

    mercury_values = calculateData(N_mercury, i_mercury, w_mercury, a_mercury, e_mercury, M_mercury)

    # venus calculations
    new_venus = planets.Venus()

    N_venus = new_venus.N + new_venus.N_ * d
    i_venus = new_venus.i + new_venus.i_ * d
    w_venus = new_venus.w + new_venus.w_ * d
    a_venus = new_venus.a
    e_venus = new_venus.e + new_venus.e_ * d
    M_venus = new_venus.M + new_venus.M_ * d

    venus_values = calculateData(N_venus, i_venus, w_venus, a_venus, e_venus, M_venus)

    #threading.Timer(1, calc).start()
    result = [
        ["{:,}".format(round(mercury_values[3])), round(mercury_values[0], 6), round(mercury_values[1], 6), round(mercury_values[2], 6)], 
        ["{:,}".format(round(venus_values[3])), round(venus_values[0], 6), round(venus_values[1], 6), round(venus_values[2], 6)],
        ["{:,}".format(round(mars_values[3])), round(mars_values[0], 6), round(mars_values[1], 6), round(mars_values[2], 6)], 
        ] 
    return result
 