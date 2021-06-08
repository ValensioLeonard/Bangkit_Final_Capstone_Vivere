# Note of explanation for machine learning model development

The development of the machine learning model in this project was done on Google Colab. There are multiple notebooks in this directory, the ones that is used for the final model is the ```Dental_Health_Classifier.ipnyb```. These versions are created for research purposes by the machine learning team at Vivere.

To replicate the steps in the notebook, you will need the teeth dataset for the model training purposes. 

Our team collected images from Google with "[Caries]"(https://drive.google.com/drive/u/1/folders/1IL0Anoxw_7Y2V2zFRudvbuzhjPmFV07O) and "[Health Teeth]"(https://drive.google.com/drive/u/1/folders/1LCD6Ijzb5waSAdM51o_xAspucnGce6hk) keywords. 


## Preprocessing on the dataset

Before the model was trained, the machine learning team did several preprocessing method that include standardizing the format of the image, redirecting the image into a path that is specifically planned for ```tensorflow image data generator``` method, this will help the labelling and data loading process for the training process. Data-Augmentation was also used to enhance the model performance.

## Model training

The model was trained using pretrained weights ```mobilenet_v2``` and then fine-tuned the last layer according to the project use case, which is classification of healthy or unhealthy teeth.

For further details, visit the ```Dental_Health_Classifier.ipnyb``` where the steps are explained better.
