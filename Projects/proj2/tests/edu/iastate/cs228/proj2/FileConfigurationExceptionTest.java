package tests.edu.iastate.cs228.proj2;

import edu.iastate.cs228.proj2.FileConfigurationException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FileConfigurationExceptionTest {
    @Test
    public void defaultConstructor(){
        try {
            throw new FileConfigurationException();
        } catch (FileConfigurationException ex){
            Assert.assertEquals("The file is not configured correctly", ex.getMessage());
        }
    }

    @Test
    public void specializedConstructor1(){
        try {
            throw new FileConfigurationException("Personal Error Message");
        } catch (FileConfigurationException ex){
            Assert.assertEquals("Personal Error Message", ex.getMessage());
        }
    }

    @Test
    public void specializedConstructor2(){
        try {
            throw new FileConfigurationException("&kjasd89090[!jfdsSDF");
        } catch (FileConfigurationException ex){
            Assert.assertEquals("&kjasd89090[!jfdsSDF", ex.getMessage());
        }
    }

}