from flask import Flask, render_template, jsonify, request
from realtimeastronomy.tester import calc
from datetime import datetime
from time import gmtime
import time

app = Flask(__name__)

@app.route('/home')
def index():
    calculations = calc()
    distanceList = [calculations[0][0], calculations[1][0], calculations[2][0], calculations[3][0], calculations[4][0], calculations[5][0]]
    currentTime = datetime.now()
    return render_template('index.html', calculations=calculations, distanceList=distanceList, currentTime=currentTime)


@app.route('/home', methods= ['GET','POST'])
def home():
    # get initial calculations
    calculations = calc()

    # get list of distances only for easier manipulation
    distanceList = [calculations[0][0], calculations[1][0], calculations[2][0], calculations[3][0], calculations[4][0], calculations[5][0]]
    distanceListMI = ["{:,}".format(round(element)) for element in distanceList]
    currentTime = time.strftime("%a, %d %b %Y %I:%M:%S %p %Z", time.localtime())

    # jasonify variables to send over
    result = jsonify({'calculations' : calculations, 'distance' : distanceListMI, 'text' : 'Distance in MI :', 'currentTime' : currentTime})

    # check if form is POST
    if request.method == 'POST':

        # get units radio button value
        units_option = (request.form.get("radio"))

        # get coordinates radio button value
        coor_option = (request.form.get("radio-coor"))

        if(coor_option == 'radioH'):
            # do for heliocentric
            result = jsonify({'calculations' : calculations, 'distance' : distanceListMI, 'text' : 'Distance in MI :', 'coorText' : 'x-coordinate (Hx) :'})

        elif(coor_option == 'radioG'):
            # do for geocentric
            result = jsonify({'calculations' : calculations, 'distance' : distanceListMI, 'text' : 'Distance in MI :', 'coorText' : 'x-coordinate (Gx) :'})

        # start checking for conversions
        if(units_option == 'radioKM'):
            distanceListKM = [element * 1.60934 for element in distanceList]
            distanceListKM = ["{:,}".format(round(element)) for element in distanceListKM]

            if(coor_option == 'radioH'):
                # do for heliocentric
                result = jsonify({'calculations' : calculations, 'distance' : distanceListKM, 'text' : 'Distance in KM :', 'coorText' : 'x-coordinate (Hx) :'})

            elif(coor_option == 'radioG'):
                # do for geocentric
                result = jsonify({'calculations' : calculations, 'distance' : distanceListKM, 'text' : 'Distance in KM :', 'coorText' : 'x-coordinate (Gx) :'})

        elif(units_option == 'radioAU'):
            distanceListAU = [element * 1.07578e-8 for element in distanceList]
            distanceListAU = ["{:,}".format(round(element, 6)) for element in distanceListAU]

            if(coor_option == 'radioH'):
                # do for heliocentric
                result = jsonify({'calculations' : calculations, 'distance' : distanceListAU, 'text' : 'Distance in AU :', 'coorText' : 'x-coordinate (Hx) :'})

            elif(coor_option == 'radioG'):
                # do for geocentric
                result = jsonify({'calculations' : calculations, 'distance' : distanceListAU, 'text' : 'Distance in AU :', 'coorText' : 'x-coordinate (Gx) :'})

    return result

if __name__ == '__main__':
    app.run(debug=True)
