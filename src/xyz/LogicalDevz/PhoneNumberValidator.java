package xyz.LogicalDevz;

import android.app.Activity;
import android.content.Context;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;

import java.util.regex.*;

@DesignerComponent(
        version = 1,
        description = "Extension by Logical Devz Team. FREE and Open Source. This extension allows you to check if a phone number is valid or not.",
        category = ComponentCategory.EXTENSION,
        nonVisible = true,
        iconName = "https://github.com/LogicalDevz/MailSender/blob/main/xyz/LogicalDevz/MailSender/aiwebres/icon.png?raw=true")

@SimpleObject(external = true)

public class PhoneNumberValidator extends AndroidNonvisibleComponent {

    //Activity and Context
    private Context context;
    private Activity activity;

    public PhoneNumberValidator(ComponentContainer container){
        super(container.$form());
        this.activity = container.$context();
        this.context = container.$context();
    }

    // Code Reference from:- https://www.javatpoint.com/mobile-number-validation-in-java

    @SimpleFunction(description = "")
    public boolean IsValid(String phoneNumber){
        boolean isValid;
        if (isValidMobileNo(phoneNumber)){
            isValid = true;
        } else{
            isValid = false;
        }
        return isValid;
    }

    public static boolean isValidMobileNo(String str)  {  
    //(0/91): number starts with (0/91)  
    //[7-9]: starting of the number may contain a digit between 0 to 9  
    //[0-9]: then contains digits 0 to 9  
    Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");  
    //the matcher() method creates a matcher that will match the given input against this pattern  
    Matcher match = ptrn.matcher(str);  
    //returns a boolean value  
    return (match.find() && match.group().equals(str));  
    }

}