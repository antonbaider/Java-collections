package com.softserve.edu.sprint4.task2;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class MyUtils {
    public Set<Student> commonStudents(List<Student> list1, List<Student> list2) {

        Set<Student> set1 = new HashSet<>(list1);
        Set<Student> set2 = new HashSet<>(list2);

        set1.retainAll(set2);

        return set1;
    }

    // Code
    public static class Student {
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return getId() == student.getId() && Objects.equals(getName(), student.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }
}
