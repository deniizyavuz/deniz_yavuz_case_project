package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String testName) {

        try {

            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            Path dir = Path.of("screenshots");

            if (!Files.exists(dir)) {
                Files.createDirectories(dir);
            }

            File src = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            Path target = dir.resolve(testName + "_" + timestamp + ".png");

            Files.copy(src.toPath(), target);

            System.out.println("Screenshot saved -> " + target);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}