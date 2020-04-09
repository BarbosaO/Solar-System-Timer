from flask import Flask, render_template, jsonify, request
from realtimeastronomy.tester import calc

app = Flask(__name__)

@app.route('/')
def index():
    calculations = calc()
    distanceList = [calculations[0][0], calculations[1][0], calculations[2][0]]
    return render_template('index.html', calculations=calculations, distanceList=distanceList)


@app.route('/home', methods= ['GET','POST'])
def home():
    calculations = calc()
    distanceList = [calculations[0][0], calculations[1][0], calculations[2][0]]
    distanceListMI = ["{:,}".format(round(element)) for element in distanceList]
    
    # jason variables to send over
    result = result = jsonify({'calculations' : calculations, 'distance' : distanceListMI, 'text' : 'Distance in MI:'})

    # check if form is POST
    if request.method == 'POST':

        # get radio button value
        option = (request.form.get("radio"))
    
        # start checking for conversions
        if(option == 'radioKM'):
            distanceListKM = [element * 1.60934 for element in distanceList]
            distanceListKM = ["{:,}".format(round(element)) for element in distanceListKM]
            result = jsonify({'calculations' : calculations, 'distance' : distanceListKM, 'text' : 'Distance in KM:'})
        elif(option == 'radioAU'):
            distanceListAU = [element * 1.07578e-8 for element in distanceList]
            distanceListAU = ["{:,}".format(round(element, 6)) for element in distanceListAU]
            result = jsonify({'calculations' : calculations, 'distance' : distanceListAU, 'text' : 'Distance in AU:'})

    return result
   
if __name__ == '__main__':
    app.run(debug=True)
