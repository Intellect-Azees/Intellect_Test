package Utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.nio.file.Paths;

import Login.UniteLogin;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Captcha {
    public String captchaText;
    String targetFolderPath = "D:\\My Files\\IntellectInfoAutomationTestWorkspace\\UniteERP\\src\\main\\resources\\Captcha Image";
    UniteLogin mt = new UniteLogin();

    public void storeCaptcha() {
    	 String srcPath = mt.captchaImagePath;

    	 try {
    	        // Extract base64 data after the comma
    	        String base64ImageData = srcPath.split(",")[1];
    	        byte[] imageBytes = Base64.getDecoder().decode(base64ImageData);
    	        // Create target folder if it doesn't exist
    	        File targetFolder = new File(targetFolderPath);
    	        if (!targetFolder.exists() && !targetFolder.mkdirs()) {
    	            throw new RuntimeException("Failed to create target folder");
    	        }

    	        // Construct the target image path
    	        String targetImagePath = Paths.get(targetFolderPath, "image.png").toString();

    	        // Write the decoded image bytes to the target file
    	        try (FileOutputStream fos = new FileOutputStream(targetImagePath)) {
    	            fos.write(imageBytes);
    	            System.out.println("Image saved successfully to: " + targetImagePath);
    	        }
    	    } catch (IllegalArgumentException e) {
    	        System.err.println("Error: Invalid base64 data - " + e.getMessage());
    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }
    }

    public String convertCaptchaToText() throws TesseractException {
        String imagePath = targetFolderPath + File.separator + "image.png";
        String tessdataDirPath = targetFolderPath + File.separator + "tessdata";
        ITesseract instance = new Tesseract();
        instance.setDatapath(tessdataDirPath);

        File imageFile = new File(imagePath);
        captchaText = instance.doOCR(imageFile);
        return captchaText;
    }

    public byte[] getCaptchaImage() throws IOException {
        String imagePath = targetFolderPath + File.separator + "image.png";
        return getImageBytes(imagePath);
    }

    private byte[] getImageBytes(String imagePath) throws IOException {
        File imageFile = new File(imagePath);
        byte[] imageBytes = new byte[(int) imageFile.length()];

        try (FileInputStream fis = new FileInputStream(imageFile)) {
            fis.read(imageBytes);
        }

        return imageBytes;
    }
}
