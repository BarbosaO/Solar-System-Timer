from flask import Flask, render_template, jsonify, request
from realtimeastronomy.tester import calc
from datetime import datetime
from time import gmtime
import time

app = Flask(__name__)

# initial routing to home page
@app.route('/home')
def index():
    calculations = calc()
    distanceList = [calculations[0][0], calculations[1][0], calculations[2][0], calculations[3][0], calculations[4][0], calculations[5][0], calculations[6][0]]
    currentTime = datetime.now()
    return render_template('index.html', calculations=calculations, distanceList=distanceList, currentTime=currentTime)


@app.route('/home', methods= ['GET','POST'])
def home():
    # get initial calculations
    calculations = calc()

    # get only heliocentric distances for easier manipulation
    distanceList = [calculations[0][0], calculations[1][0], calculations[2][0], calculations[3][0], calculations[4][0], calculations[5][0], calculations[6][0]]

    # get geocentric data from calculations
    geocentricData = [calculations[0][4], calculations[1][4], calculations[2][4], calculations[3][4], calculations[4][4], calculations[5][4], calculations[6][4]]

    # get only geocentric distances for easier manipulations
    geoDistances = [geocentricData[0][0], geocentricData[1][0], geocentricData[2][0], geocentricData[3][0], geocentricData[4][0], geocentricData[5][0], geocentricData[6][0]]

    # format helocentric distances
    distanceListMI = ["{:,}".format(round(element)) for element in distanceList]

    # format geocentric distances
    geoDistancesMI = ["{:,}".format(round(element)) for element in geoDistances]

    currentTime = time.strftime("%a, %d %b %Y %I:%M:%S %p %Z", time.localtime())

    # jasonify variables to send over
    result = jsonify({'calculations' : calculations, 'distance' : distanceListMI, 'text' : 'Distance in MI :', 'currentTime' : currentTime})

    # check if form is POST
    if request.method == 'POST':

        # get units radio button value
        units_option = (request.form.get("radio"))

        # get coordinates radio button value
        coor_option = (request.form.get("radio-coor"))

        hxCoordinateText = ['Heliocentric (\\(H_x)\\) :', 'Heliocentric (\\(H_y)\\) :', 'Heliocentric (\\(H_z)\\) :']
        gxCoordinateText= ['Geocentric (\\(G_x)\\) :', 'Geocentric (\\(G_y)\\) :', 'Geocentric (\\(G_z)\\) :']

        if(coor_option == 'radioH'):
            # do for heliocentric
            result = jsonify({'calculations' : calculations, 'distance' : distanceListMI, 'geoDistance' : geoDistancesMI, 'text' : 'Distance in MI :', 'coorText' : hxCoordinateText})

        elif(coor_option == 'radioG'):
            # do for geocentric
            result = jsonify({'calculations' : geocentricData, 'distance' : geoDistancesMI, 'geoDistance' : geoDistancesMI, 'text' : 'Distance in MI :', 'coorText' : gxCoordinateText})

    
        # start checking for conversions
        if(units_option == 'radioKM'):
            distanceListKM = [element * 1.60934 for element in distanceList]
            distanceListKM = ["{:,}".format(round(element)) for element in distanceListKM]
            
            # KM conversion for geoncentric distances
            geoDistanceListKM = [element * 1.60934 for element in geoDistances]
            geoDistanceListKM = ["{:,}".format(round(element)) for element in geoDistanceListKM]

            if(coor_option == 'radioH'):
                # do for heliocentric
                result = jsonify({'calculations' : calculations, 'distance' : distanceListKM, 'text' : 'Distance in KM :', 'coorText' : hxCoordinateText})

            elif(coor_option == 'radioG'):
                # do for geocentric
                result = jsonify({'calculations' : geocentricData, 'distance' : geoDistanceListKM, 'text' : 'Distance in KM :', 'coorText' : gxCoordinateText})

        elif(units_option == 'radioAU'):

            # AU conversion for heliocentric distances
            distanceListAU = [element * 1.07578e-8 for element in distanceList]
            distanceListAU = ["{:,}".format(round(element, 6)) for element in distanceListAU]

            # AU conversion for geocentric distances
            geoDistanceListAU = [element * 1.07578e-8 for element in geoDistances]
            geoDistanceListAU = ["{:,}".format(round(element, 6)) for element in geoDistanceListAU]
            
            if(coor_option == 'radioH'):
                # do for heliocentric
                result = jsonify({'calculations' : calculations, 'distance' : distanceListAU, 'text' : 'Distance in AU :', 'coorText' : hxCoordinateText})

            elif(coor_option == 'radioG'):
                # do for geocentric
                result = jsonify({'calculations' : geocentricData, 'distance' : geoDistanceListAU, 'text' : 'Distance in AU :', 'coorText' : gxCoordinateText})

    return result

if __name__ == '__main__':
    app.run(debug=True)
