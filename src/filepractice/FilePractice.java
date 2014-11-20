/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filepractice;

import java.io.*;

/**
 *
 * @author Alex
 */
public class FilePractice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        File data = new File(File.separatorChar + "tempFolder" + File.separatorChar
                + "ContactList.txt");

        BufferedReader in = null;
        Record record = null;
        RecordsList list = new RecordsList();
        
        
        try {

            in = new BufferedReader(new FileReader(data));
            String line = in.readLine();

            while (line != null) {

                if (line.isEmpty()) {
                    
                    record = new Record();

                    line = in.readLine(); // next line = nameParts[] firstName = nameParts[0]
                                          //                         lastName = nameParts[1]
                    
                    String[] nameParts = line.split(" ");
                    record.setFirstName(nameParts[0]);
                    record.setLastName(nameParts[1]);

                    line = in.readLine(); //next line ( address )

                    String streetAddress = line;
                    record.setStreetAddress(streetAddress);

                    line = in.readLine(); //next line ( city state and zip )

                    String[] city_state_zip = line.split(" ");
                    record.setCity(city_state_zip[0]);
                    record.setState(city_state_zip[1]);
                    record.setZip(city_state_zip[2]);

                    line = in.readLine(); // next line ( phone number )

                    String contactPhoneNumber = line;
                    record.setPhone(contactPhoneNumber);
                    
                    list.addRecordToList(record);
                    
                }
                line = in.readLine();
            }

        } catch (IOException ioe) {
            System.out.println("Houston, we have a problem! reading this file");
        } finally {
            try {
                in.close();
            } catch (Exception e) {

            }
        } 

        System.out.println(list.getRecordByPhoneIdentifier("2147")); 
        
    }

}
