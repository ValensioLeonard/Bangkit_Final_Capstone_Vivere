import numpy as np
import os
import tensorflow as tf
import tensorflow_hub as hub
import matplotlib.pyplot as plt
from tqdm import tqdm
from shutil import copyfile
import re
from shutil import move
from werkzeug.utils import secure_filename
import urllib.request

from tensorflow.keras.preprocessing.image import ImageDataGenerator
from tensorflow.keras.preprocessing import image

# from keras.models import load_model
# from keras.preprocessing import image

# Flask utils
from flask import Flask, redirect, url_for, request, render_template, jsonify, flash
#from flask_ngrok import run_with_ngrok

# Define a flask app
app = Flask(__name__)
#run_with_ngrok(app)

# Load your trained model
model = tf.keras.models.load_model('modelv1.h5',custom_objects={'KerasLayer':hub.KerasLayer})
model.make_predict_function()          # Necessary

def model_predict(img_path, model):
    img = image.load_img(img_path, target_size=(224, 224))

    # Preprocessing the image
    x = image.img_to_array(img)
    x = np.expand_dims(x, axis=0)
    images = np.vstack([x])/ 255.0

    preds = model.predict(images)
    if preds[0] > 0.5:
      return "Gigi sehat."
    else:
      return "Gigi Karies."

@app.route('/')
def index():
  return """
          Application is working
  """

@app.route('/predict', methods=['POST', 'GET'])
def upload_image():
  if request.method == 'POST':
    f = request.files['file']
    file_path = secure_filename(f.filename)
    f.save(file_path)

    #make prediction
    preds = model_predict(file_path, model)
    return preds

if __name__ == '__main__':
    # app.debug = True
    app.run()