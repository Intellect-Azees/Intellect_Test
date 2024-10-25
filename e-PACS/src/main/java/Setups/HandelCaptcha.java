package Setups;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class HandelCaptcha {
    private String tempImg;
    public String text;

    public HandelCaptcha(String captchaSrc) 
    {
        this.tempImg = captchaSrc;
    }
/*
 * 
 */
    public Boolean captcha()
    {
        if (tempImg != null)
        {
            try 
            {
                String[] parts = tempImg.split(","); 
                String imageData = parts.length > 1 ? parts[1] : parts[0];
                byte[] imageBytes = Base64.getDecoder().decode(imageData); 
                ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
                BufferedImage bufferedImage = ImageIO.read(bis);
                Tesseract tesseract = new Tesseract();
                String tessdataPath = "C:\\Git\\Intellect_Test\\e-PACS\\src\\main\\resources\\tessdata";
                System.setProperty("TESSDATA_PREFIX", tessdataPath);
                tesseract.setDatapath(tessdataPath);  
                tesseract.setLanguage("eng");  
                text = tesseract.doOCR(bufferedImage);
                return true;
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
                return false;
            } 
            catch (TesseractException e) 
            {
                e.printStackTrace();
                return false;
            }   
        }
        else 
        {
        	return false;
        }
    }
}
