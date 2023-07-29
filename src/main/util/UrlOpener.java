package main.util;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class UrlOpener {

    public static void openWebPage(String url){
        try {
            URI uri = new URL(url).toURI();
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if(desktop != null && desktop.isSupported(Desktop.Action.BROWSE)){
                desktop.browse(uri);
            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
