import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/* Exercise Set
Create a class called 'FavoriteLanguage' that has the following attributes:
name, YearOfCreation and ide. Then create a set with
3 languages and make a program that sorts this set
per:

A. Order of Insertion
B. Alphabetical Order (name)
C. IDE
D. Year of creation and name
E. Name, year of creation and IDE

At the end, display the languages in the console, one below the other.
 */
public class FavoriteLanguageExercise {

    public static void main(String[] args) {
        Set<FavoriteLanguage> languages = new LinkedHashSet<>() {
            {
                add(new FavoriteLanguage("Javascript", 1995, "Visual Studio Code"));
                add(new FavoriteLanguage("C", 1970, "Code::Blocks"));
                add(new FavoriteLanguage("Java", 1991, "Eclipse"));
                add(new FavoriteLanguage("Python", 1989, "PyCharm"));
                add(new FavoriteLanguage("C++", 1983, "Visual Studio Code"));
                add(new FavoriteLanguage("PHP", 1994, "Sublime Text"));
            }
        };

        System.out.println("Order of insertion:");
        System.out.println(languages);
        System.out.println("------------------------");

        System.out.println("Alphabetical Order (name)");
        Set<FavoriteLanguage> languagesAlphabeticalOrder = new TreeSet<FavoriteLanguage>(languages);
        System.out.println(languagesAlphabeticalOrder);
        System.out.println("------------------------");

        System.out.println("Sort by IDE");
        Set<FavoriteLanguage> languagesSortedByIDE = new TreeSet<FavoriteLanguage>(new ComparatorIDE());
        languagesSortedByIDE.addAll(languagesAlphabeticalOrder);
        System.out.println(languagesSortedByIDE);
        System.out.println("------------------------");

        System.out.println("Sort by Year of creation and name");
        Set<FavoriteLanguage> languagesSortedByYearAndName = new TreeSet<FavoriteLanguage>(new ComparatorYearAndName());
        languagesSortedByYearAndName.addAll(languagesAlphabeticalOrder);
        System.out.println(languagesSortedByYearAndName);
        System.out.println("------------------------");

        System.out.println("Sort by Name, year of creation and IDE");
        Set<FavoriteLanguage> languagesSortedByNameYearAndIDE = new TreeSet<FavoriteLanguage>(
                new ComparatorNameYearAndIDE());
        languagesSortedByNameYearAndIDE.addAll(languagesAlphabeticalOrder);
        System.out.println(languagesSortedByNameYearAndIDE);
        System.out.println("------------------------");
    }
}

class FavoriteLanguage implements Comparable<FavoriteLanguage> {
    private String name;
    private int yearOfCreation;
    private String ide;

    public FavoriteLanguage(String name, int yearOfCreation, String ide) {
        this.name = name;
        this.yearOfCreation = yearOfCreation;
        this.ide = ide;
    }

    public String getName() {
        return name;
    }

    public int getYearOfCreation() {
        return yearOfCreation;
    }

    public String getIde() {
        return ide;
    }

    @Override
    public String toString() {
        return "\nName = " + name + ", Year of creation = " + yearOfCreation + ", IDE = " + ide;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + yearOfCreation;
        result = prime * result + ((ide == null) ? 0 : ide.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FavoriteLanguage other = (FavoriteLanguage) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (yearOfCreation != other.yearOfCreation)
            return false;
        if (ide == null) {
            if (other.ide != null)
                return false;
        } else if (!ide.equals(other.ide))
            return false;
        return true;
    }

    @Override
    public int compareTo(FavoriteLanguage o) {
        return this.getName().compareTo(o.getName());
    }
}

class ComparatorIDE implements Comparator<FavoriteLanguage> {

    @Override
    public int compare(FavoriteLanguage o1, FavoriteLanguage o2) {
        return o1.getIde().compareTo(o2.getIde());
    }
}

class ComparatorYearAndName implements Comparator<FavoriteLanguage> {

    @Override
    public int compare(FavoriteLanguage o1, FavoriteLanguage o2) {
        int yearOfCreation = Integer.compare(o1.getYearOfCreation(), o2.getYearOfCreation());
        if (yearOfCreation != 0)
            return yearOfCreation;

        return o1.getName().compareTo(o2.getName());
    }
}

class ComparatorNameYearAndIDE implements Comparator<FavoriteLanguage> {

    @Override
    public int compare(FavoriteLanguage o1, FavoriteLanguage o2) {
        int name = o1.getName().compareTo(o2.getName());
        if (name != 0)
            return name;

        int yearOfCreation = Integer.compare(o1.getYearOfCreation(), o2.getYearOfCreation());
        if (yearOfCreation != 0)
            return yearOfCreation;

        return o1.getIde().compareTo(o2.getIde());
    }
}