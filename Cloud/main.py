import cv2
import io
import os
import numpy as np
from numpy import asfarray
import tensorflow as tf
import tensorflow_hub as hub
from tqdm import tqdm
from werkzeug.utils import secure_filename
import urllib.request

from tensorflow.keras.preprocessing.image import ImageDataGenerator
from tensorflow.keras.preprocessing import image

# Flask utils
from flask import Flask, redirect, url_for, request, render_template, jsonify, flash

# Define a flask app
app = Flask(__name__)

# Load your trained model
model = tf.keras.models.load_model('modelv1.h5',custom_objects={'KerasLayer':hub.KerasLayer})
model.make_predict_function()          # Necessary

def model_predict(img_path, model):
    img = img_path
    x = cv2.imdecode(np.fromstring(img.read(), np.uint8), cv2.IMREAD_UNCHANGED)
    x = cv2.resize(x,(224,224))
    x = np.expand_dims(x, axis=0)
    images = np.vstack([x])/ 255.0

    preds = model.predict(images)
    if preds[0] > 0.5:
      # return jsonify({"message": "Gigi sehat."})
      return "Gigi Sehat."
    else:
      return jsonify({"message": "Gigi Karies."})
      return "Gigi Karies."


@app.route('/')
def index():
  return render_template("upload.html")


@app.route('/predict', methods=['POST', 'GET'])
def predict():
  if request.method == 'POST':
    f = request.files['file']
    preds = model_predict(f, model)
    return preds

if __name__ == '__main__':
    app.run(debug=True)
