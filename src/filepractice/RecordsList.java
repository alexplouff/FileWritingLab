/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filepractice;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex
 */
public class RecordsList {
    
    private List<Record> recordsList;
    private Record record;
    
    public RecordsList(){
        recordsList = new ArrayList<>();
    }

    public List<Record> getRecordsList() {
        return recordsList;
    }

    public void addRecordToList(Record record) {
         recordsList.add(record);
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }
    
    public Record getRecordByFirstName(String firstName){
        Record requestedRecord = null;
        for(Record records : recordsList){
            if(firstName.equals(records.getFirstName())){
                requestedRecord = records;
                return requestedRecord;
            }
        }
        return requestedRecord;       
    }
    
    public Record getRecordByPhoneIdentifier(String lastFourOfPhone){
        Record requestedRecord = null;
        for(Record records : recordsList){
            if(lastFourOfPhone.equals(records.getPhone().substring(8, 12))){
                requestedRecord = records;
                return requestedRecord;
            }
        }
        return requestedRecord;       
    }
    
}
