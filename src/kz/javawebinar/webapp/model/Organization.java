package kz.javawebinar.webapp.model;

import java.util.Date;
import java.util.List;

/**
 * Aser
 * 19.05.2015
 */
public class Organization {
    private Link link;
    private List<Period> periods;

    public Organization() {
    }

    public static class Period {
        private Date startDate;
        private Date endDate;
        private String position;
        private String content;

        public Period(Date startDate, Date endDate, String position, String content) {
            this.startDate = startDate;
            this.endDate = endDate;
            this.position = position;
            this.content = content;
        }

        public Period() {
        }
    }
}
