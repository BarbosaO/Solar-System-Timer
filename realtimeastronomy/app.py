from flask import Flask, render_template

from tester import calc

result = calc()
print(result)
app = Flask(__name__)

@app.route('/')
def hello():
    return result

if __name__ == '__main__':
    app.run()