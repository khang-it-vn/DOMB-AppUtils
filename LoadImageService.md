## 1. Load And setimage using url
package app_utils.ktteam.src.Utils;


public class LoadImageService {

    private ImageView imageView;
    private String url;
    private String imageName;

    public LoadImageService(ImageView imageView, String url, String imageName) {
        this.imageView = imageView;
        this.url = url;
        this.imageName = imageName;
    }



    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }


    public static void loadImageFor(LoadImageService imageService)
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        URL url = null;
        try {
            url = new URL(imageService.getUrl() + imageService.getImageName());
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            imageService.getImageView().setImageBitmap(bmp);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


## 2. ENVIROMENT FOR URL
  package app_utils.ktteam.src;

  public  class ENVIROMENT {
      public static final String DOMAIN = "http://192.168.1.182:5000/v1/api/";
      public static final String DOMAIN_GET_IMAGE = DOMAIN + "Repairer/GetImageByName?imageName=";
  }
> Demo:
  imgViewSearchHinhAnh = findViewById(R.id.imgviewSearchHinhAnh)
  LoadImageService.loadImageFor(new LoadImageService(imgviewSearchHinhAnh, ENVIROMENT.DOMAIN_GET_IMAGE,data.getAvatar()));
