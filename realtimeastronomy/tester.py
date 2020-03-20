import datetime
import threading
from planets import Mars, Mercury, Venus
from calculator import calculateData
import tkinter as Tkinter 


def calc():
    # calculating UT and d
    currentDT = datetime.datetime.now()
    UT = currentDT.hour + (currentDT.minute / 60.0) + (currentDT.second / 3600)
    year = currentDT.year
    month = currentDT.month
    day = currentDT.day

    d_0 = 367 * 1999 - (7 * (1999 + ((12 + 9) / 12))) / 4 - (3 * ((1999 + (12 - 9) / 7) / 100 + 1)) / 4 + (275 * 12) / 9 + 29.50 - 730515

    #d = 367 * year - (7 * (year + ((month + 9) / 12))) / 4 - (3 * ((year + (month - 9) / 7) / 100 + 1)) / 4 + (275 * month) / 9 + day - 730515
    d = 367 * year - (7 * (year + ((month + 9) / 12))) / 4  + (275 * month) / 9 + day - 730530
    d += UT/24 + (-1 * d_0) / 10
    

    # mars calculations
    new_Mars = Mars()

    N_mars = new_Mars.N + new_Mars.N_ * d
    i_mars = new_Mars.i + new_Mars.i_ * d
    w_mars = new_Mars.w + new_Mars.w_ * d
    a_mars = new_Mars.a
    e_mars = new_Mars.e + new_Mars.e_ * d
    M_mars = new_Mars.M + new_Mars.M_ * d

    mars_miles = calculateData(N_mars, i_mars, w_mars, a_mars, e_mars, M_mars)

    # mercury calculations
    new_mercury = Mercury()

    N_mercury = new_mercury.N + new_mercury.N_ * d
    i_mercury = new_mercury.i + new_mercury.i_ * d
    w_mercury = new_mercury.w + new_mercury.w_ * d
    a_mercury = new_mercury.a
    e_mercury = new_mercury.e + new_mercury.e_ * d
    M_mercury = new_mercury.M + new_mercury.M_ * d

    mercury_miles = calculateData(N_mercury, i_mercury, w_mercury, a_mercury, e_mercury, M_mercury)

    # venus calculations
    new_venus = Venus()

    N_venus = new_venus.N + new_venus.N_ * d
    i_venus = new_venus.i + new_venus.i_ * d
    w_venus = new_venus.w + new_venus.w_ * d
    a_venus = new_venus.a
    e_venus = new_venus.e + new_venus.e_ * d
    M_venus = new_venus.M + new_venus.M_ * d

    venus_miles = calculateData(N_venus, i_venus, w_venus, a_venus, e_venus, M_venus)

    result = ("{:,}".format(round(mars_miles)), "{:,}".format(round(mercury_miles)), "{:,}".format(round(venus_miles)))

    return result
 