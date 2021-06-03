# KohiNoka

Apps for detecting diseases on a coffee plant by take coffee leaf photo. We use machine learning to process the photo and find the diseases.
The apps will give some tips and video for the user, how to overcome the problem

ML is imported by using TFLITE file. 
To do that we need to add TensorFlow in our dependencies and copy the tflife file to assets folder.

The articles database and video link is stored in Google Cloud FireStore. 
To get the data, we need to connect the app to FireStore and make a database object. 

There are some menu that we can run in the app:
1. Scan Product: scan the coffee leaf and detect the diseases. Then the app will give the solution.
2. Article: you can find some article related to coffee plant.
3. Video: you can find some video related to coffee plant. We get the videos data from Youtube API.

Every list in this app use Recycler View.
