package com.yclients.n63033.beatysalon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Егор on 27.04.2017.
 */

public class ParametersRecord {
    private static int companyId;
    private static int staffId;
    private static List<Integer> servicesIds = new ArrayList<>();

    public static int getCompanyId() {
        return companyId;
    }

    public static void setCompanyId(int companyId) {
        ParametersRecord.companyId = companyId;
    }

    public static int getStaffId() {
        return staffId;
    }

    public static void setStaffId(int staffId) {
        ParametersRecord.staffId = staffId;
    }

    public static List<Integer> getServicesIds() {
        return servicesIds;
    }

    public static void setServicesIds(List<Integer> servicesIds) {
        ParametersRecord.servicesIds = servicesIds;
    }
}
