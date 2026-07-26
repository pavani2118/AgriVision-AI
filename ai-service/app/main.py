from fastapi import FastAPI, UploadFile, File
from app.predict import predict


app = FastAPI()


@app.get("/")
def home():
    return {
        "message":"AgriVision AI Service Running"
    }


@app.post("/predict")
async def prediction(
        file: UploadFile = File(...)
):

    image_bytes = await file.read()


    result = predict(image_bytes)


    return {
        "filename": file.filename,
        **result
    }