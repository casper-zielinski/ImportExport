package at.fhj.msd;

public class Schedeule {

      private String cohort;
      private String group;
      private String lecture;
      private String starts;
      private String ends;
      private String lecturer;
      private String place;

      public Schedeule(String cohort, String group, String lecture, String starts, String ends, String lecturer, String place)
      {
            this.cohort = cohort;
            this.group = group;
            this.lecture = lecture;
            this.starts = starts;
            this.ends = ends;
            this.lecturer = lecturer;
            this.place = place;

            if (!(cohort.startsWith("SWD")))
            {
                  throw new IllegalArgumentException("Only schedules with a cohort starting with SWD are \"valid\" for our example!");
            }
      }

      public String asCsv(String d)
      {
            return String.format("%s%s%s%s%s%s%s%s%s%s%s%s%s\n",
            this.cohort, d, this.group,d, this.lecture,d,this.starts,d,
            this.ends,d,this.lecturer,d,this.place);
      }

      public String asSql()
      {
            return String.format("INSERT INTO schedeules VALUES (%s,%s,%s,%s,%s,%s,%s) \n",
            this.cohort, this.group,this.lecture,this.starts, this.ends, this.lecturer, this.place);
      }
}
