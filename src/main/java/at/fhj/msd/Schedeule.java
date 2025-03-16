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
}
