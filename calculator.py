import math
def calculateData(N, i, w, a, e, M):
    # verify that w and M are between 0 and +360
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
        E_1 = E_0 - (E_0 - e * math.sin(E_0) - M) / (1 - e * math.cos(E_0))

        error = abs(E_1 -E_0)
        E_0 = E_1

        if(error < 1.745329E-5):
            break
    
    E_0 *= toRadians
    x = a * (math.cos(E) - e)
    y = a * (math.sqrt(1.0 - e * e) * math.sin(E))
    v = math.degrees(math.atan2(y , x))

    if(v < 0.0):
        v += 360.0

    r = math.sqrt(x * x + y * y)
    rMi = r * 92955807.26743

    xh = r * (math.cos(toRadians * N) * math.cos(toRadians * (v+w)) - math.sin(toRadians * N) * math.sin(toRadians * (v+w)) * math.cos(toRadians * i))
    yh = r * (math.sin(toRadians * N) * math.cos(toRadians * (v+w)) + math.cos(toRadians * N) * math.sin(toRadians * (v+w)) * math.cos(toRadians * i))
    zh = r * (math.sin(toRadians * (v+w)) * math.sin(toRadians * i))

    rh = math.sqrt(xh * xh + yh * yh + zh * zh)
    rhMi = rh * 92955807.26743

    return rhMi
    