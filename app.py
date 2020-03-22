from flask import Flask, render_template, jsonify
from apscheduler.schedulers.background import BackgroundScheduler
from realtimeastronomy.tester import calc

app = Flask(__name__)

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/home', methods= ['POST'])
def home():
    calculations = calc()
    return jsonify({'data' :  render_template('home.html', calculations=calculations)})
   
if __name__ == '__main__':
    app.run(debug=True)
