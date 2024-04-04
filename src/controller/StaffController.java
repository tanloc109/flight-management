package controller;

import dto.Staff;
import java.util.ArrayList;
import java.util.List;

public class StaffController {

    private List<Staff> staffs = new ArrayList();

    public StaffController() {
        staffs.add(new Staff(1, "John Smith", "Captain"));
        staffs.add(new Staff(2, "Alice Johnson", "Captain"));
        staffs.add(new Staff(3,"Robert Davis", "Co-Pilot"));
        staffs.add(new Staff(4,"Eva White", "Co-Pilot"));
        staffs.add(new Staff(5,"Sarah Clark", "Flight Attendant"));
        staffs.add(new Staff(6,"Michael Turner", "Flight Attendant"));
        staffs.add(new Staff(7,"Laura Wilson", "Flight Attendant"));
        staffs.add(new Staff(8,"David Harris", "Flight Attendant"));
        staffs.add(new Staff(9,"Emma Brown", "Flight Attendant"));
        staffs.add(new Staff(10,"James Johnson", "Mechanic"));
        staffs.add(new Staff(11,"Olivia Lee", "Navigator"));
        staffs.add(new Staff(12,"Sophia Martinez", "Dispatcher"));
        staffs.add(new Staff(13,"Matthew Anderson", "Flight Surgeon"));
        staffs.add(new Staff(14,"Chloe Jackson", "Cabin Crew"));
        staffs.add(new Staff(15,"Daniel Young", "Flight Attendant"));
        staffs.add(new Staff(16,"Ava Davis", "Co-Pilot"));
        staffs.add(new Staff(17,"Liam Wilson", "Captain"));
        staffs.add(new Staff(18,"Mia Harris", "Flight Attendant"));
        staffs.add(new Staff(19,"Benjamin White", "Flight Attendant"));
        staffs.add(new Staff(20,"Charlotte Turner", "Captain"));
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public boolean addStaff(Staff staff) {
        try {
            staffs.add(staff);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(int staffId) {
        try {
            for (Staff staff : staffs) {
                if (staff.getStaffId() == staffId) {
                    staffs.remove(staff);
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Staff getStaffById(int staffId) {
        for (Staff staff : staffs) {
            if (staff.getStaffId() == staffId) {
                return staff;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        return "StaffController{" + "staffs=" + staffs + '}';
    }

}
