# ANDROID MOBILE APP - DENTAL CARIES DETECTION
__By VIVERE (B21-CAP0095) for Bangkit Capstone Project 2021__

### Feature
- Add image by capture with camera or pick from gallery and crop image ([using this library](https://github.com/Dhaval2404/ImagePicker))
- Sending image to the Dental Caries Detection APIs by using [Retrofit library](https://github.com/square/retrofit)

## How the App works?
- User should input an image to the app (by gallery or capture it first using camera), user can still change the image after they put the first image
- The image will be set as an imageURI and get the image location path from it
- The image will be send by the app using the Retrofit library after the user done choosing the image and click the continue button
- After the API return the message, which is the prediction result, the app will move to the next activity based on the result

## App Interface
- SplashScreenActivity
  
  ![SplashScreenActivity](https://cdn.discordapp.com/attachments/782762685502455871/852181323602198548/activity_splash_screen.jpg)

- MainActivity
  
  ![MainActivity](https://cdn.discordapp.com/attachments/782762685502455871/852181342346412092/activity_main.jpg)
  
- TutorialActivity
  
  ![TutorialActivity](https://cdn.discordapp.com/attachments/782762685502455871/852181360265527326/activity_tutorial.jpg)

- PictSelectionActivity
  
  ![PictSelectionActivity](https://cdn.discordapp.com/attachments/782762685502455871/852182701440237579/activity_pict_selection.jpg)

- BadResultActivity
  
  ![BadResultActivity](https://cdn.discordapp.com/attachments/782762685502455871/852181387993022544/activity_bad_result.jpg)

- GoodResultActivity
  
  ![GoodResultActivity](https://cdn.discordapp.com/attachments/782762685502455871/852181405249044531/activity_good_result.jpg)

### Compatibility
- Android Lollipop 5.0+ (API 21)

### Public Libraries & APIs Used
- Image Picker by [Dhaval2404](https://github.com/Dhaval2404) (https://github.com/Dhaval2404/ImagePicker)
- Retrofit by [Square](https://github.com/square) (https://github.com/square/retrofit)
- Dental Caries Detections APIs by [VIVERE](https://github.com/ValensioLeonard/Bangkit_Final_Capstone_Vivere/tree/main/Cloud) (Web Interface : https://newagent-9pky.ue.r.appspot.com/)

## Changelog
- Version 2.0 (Second Commit)
  - Added some APIs functionalities (interface ApiService, ApiConfig and postImageToApi function) but still not working well
  - Added new layouts for final result (goodResultActivity and badResultActivity)
- Version 1.0 (Intitial Commit)
- Version 1.0
  - Initial commit
  - Add image (by camera and gallery) and crop image features can already working
  
## Meet the Android Team
- Royyan Jovan Baswara (A0090983) - Universitas Gunadarma
- Koes Safira Amanidyansari (A2992706) - Universitas Pendidikan Indonesia
