import tempfile
from app.model import predict_image


def predict(file):

    with tempfile.NamedTemporaryFile(delete=False) as temp:

        temp.write(file)

        temp_path = temp.name


    result = predict_image(temp_path)

    return result