import math

def calculateData(N, i, w, a, e, M):
    # verify that w and M are between 0 and +360

    if(N < 0 or N > 360):
        n = (int)(N / 360)
        if(w < 0):
            N += 360 * n
        else:
            N -= 360 * n

    if(w < 0 or w > 360):
        n = (int)(w / 360)
        if(w < 0):
            w += 360 * n
        else:
            w -= 360 * n

    if(M < 0 or M > 360):
        k = (int)(M / 360)
        if(M < 0):
            M += 360 * k
        else:
            M -= 360 * k

    toRadians = math.pi / 180
    
    # get initial value for E
    E = toRadians * M + e * math.sin(toRadians * M) * (1.0 + e * math.cos(toRadians * M))
    E_0 = E

    # perform iteration until accurate enough
    while(True):
        E_1 = E_0 - (E_0 - e * math.sin(E_0 * toRadians) - M) / (1 - e * math.cos(toRadians *  E_0))

        error = abs(E_1 -E_0)
        E_0 = E_1

        if(error < 1.0e-8):
            break
    
    x = a * (math.cos(E) - e)
    y = a * (math.sqrt(1.0 - e * e) * math.sin(E))
    v = math.degrees(math.atan2(y , x))

    if(v < 0.0):
        v += 360.0

    r = math.sqrt(x * x + y * y)
    rMi = r * 92955807.26743

     # get heliocentric cartesian coordinates for planet
    xh = r * (math.cos(toRadians * N) * math.cos(toRadians * (v+w)) - math.sin(toRadians * N) * math.sin(toRadians * (v+w)) * math.cos(toRadians * i))
    yh = r * (math.sin(toRadians * N) * math.cos(toRadians * (v+w)) + math.cos(toRadians * N) * math.sin(toRadians * (v+w)) * math.cos(toRadians * i))
    zh = r * (math.sin(toRadians * (v+w)) * math.sin(toRadians * i))

    # get heliocentric distance
    rh = math.sqrt(xh * xh + yh * yh + zh * zh)

    # get ecliptic longitude and latitude to correct for perturbations (Jupiter, Saturn, and Uranus only)
    lonecl = math.degrees(math.atan2(yh, xh) * toRadians)

    if(lonecl < 0.0):
        lonecl += 360.0
    
    latecl = math.degrees(math.atan2(zh, math.sqrt(xh * xh + yh * yh) * toRadians))

    if(latecl < 0):
        latecl += 360.0

    # converting factor from 1 AU to 1 mile
    milesPerAu = 92955807.26743

    # get current distance in miles
    rhMi = rh * milesPerAu
    
    # calculate geocentric distances

    # store returning values
    values = [xh, yh, zh, rhMi, lonecl, latecl, r]

    return values
    