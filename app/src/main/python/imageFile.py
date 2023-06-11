import openai
def main(DATA):
    openai.api_key = "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"
    response = openai.Image.create(
    prompt=DATA,
    n=1,
    size="1024x1024"
    )
    image_url = response['data'][0]['url']
    return image_url
