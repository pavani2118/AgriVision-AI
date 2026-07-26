import tensorflow as tf
import numpy as np
from tensorflow.keras.preprocessing import image


MODEL_PATH = "models/plant_disease_model.keras"


model = tf.keras.models.load_model(MODEL_PATH)


classes = [
    "Potato___Early_blight",
    "Potato___Late_blight",
    "Potato___healthy",
    "Tomato___Early_blight",
    "Tomato___Late_blight",
    "Tomato___healthy"
]


def predict_image(img_path):

    img = image.load_img(
        img_path,
        target_size=(224,224)
    )

    img_array = image.img_to_array(img)

    img_array = np.expand_dims(
        img_array,
        axis=0
    )

    img_array = img_array / 255.0


    prediction = model.predict(img_array)


    index = np.argmax(prediction)

    confidence = float(
        np.max(prediction) * 100
    )


    disease = classes[index]


    return {
        "disease": disease,
        "confidence": round(confidence,2)
    }