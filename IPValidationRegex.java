/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ipvalidationregex;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPValidationRegex {
    
    private static Pattern VALID_IP_ADDRESS_PATTERN = null;
    private static String ip_address = "(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])";
    private static Matcher matcher;
    

    public static void main(String[] args) {
        // TODO code application logic here
        VALID_IP_ADDRESS_PATTERN = Pattern.compile(ip_address);
        try{
            InputStream fileIs = IPValidationRegex.class.getResourceAsStream("IP.txt");
            try (BufferedReader br = new BufferedReader(new InputStreamReader(fileIs))) {
                String line;
                System.out.println("Invalid IP Address");
                System.out.println("==================");
                while ((line = br.readLine()) != null) {
                   // process the line.
                    matcher = VALID_IP_ADDRESS_PATTERN.matcher(line);
                    if(!matcher.matches())
                    {
                        System.out.println(line);
                    }
                }
            }
        }catch (Exception ex)
        {
            System.out.println("File not found!!");
        }        
    }
    
}
