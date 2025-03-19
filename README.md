# Import Export Project

## Description

1. A Method that reads a file (a text) and returns an Array List with the Schedeules in the file with error checking. (``readData`` Method)

2.

## Notes

- The file should be designed in a way for the reader Method ``readData`` to read: Example:

> SWDCohort3;group3;lecture3;starts3;ends3;lecturer3;place3
>
> SWDCohort;group;lecture;starts;ends;lecturer;place

- It should seperate the attributes with a ";".
- The Elements of Schedeule are:

> ```
>      private String cohort;
>      private String group;
>      private String lecture;
>      private String starts;
>      private String ends;
>      private String lecturer;
>      private String place;
>```

- These are also the attributes used in The file that is being read by the ``readData`` Method
