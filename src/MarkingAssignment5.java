import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarkingAssignment5 {

    @Test
    void testBasic() {
        BSTDictionary<String, SortableString> dictionary = new BSTDictionary<>();

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                String s = "";
                s += ((char) ((int) 'A' + i));
                s += ((char) ((int) 'A' + j));
                dictionary.insert(new SortableString(s), s);
            }
        }

        assertEquals(676, dictionary.depth());

        dictionary.delete(new SortableString("AA"));
        dictionary.delete(new SortableString("AA"));
        dictionary.delete(new SortableString("12"));
        assertEquals(675, dictionary.depth());

        dictionary.delete(new SortableString("AC"));
        assertEquals(674, dictionary.depth());

    }

    @Test
    void removeParentWith2Children() {
        BSTDictionary<String, SortableString> dictionary = new BSTDictionary<>();

        dictionary.insert(new SortableString("Janet"), "Janet");
        dictionary.insert(new SortableString("Bob"), "Bob");
        dictionary.insert(new SortableString("Alan"), "Alan");
        dictionary.insert(new SortableString("Ellen"), "Ellen");
        dictionary.insert(new SortableString("Tom"), "Tom");
        dictionary.insert(new SortableString("Karen"), "Karen");
        dictionary.insert(new SortableString("Wendy"), "Wendy");

        assertEquals(3, dictionary.depth());

        dictionary.insert(new SortableString("Zach"), "Zach");

        assertEquals(4, dictionary.depth());

        dictionary.insert(new SortableString("Zachary"), "Zachary");

        dictionary.delete(new SortableString("Janet"));

        assertEquals(5, dictionary.depth());

        dictionary.delete(new SortableString("Tom"));

        assertEquals(4, dictionary.depth());
    }

    @Test
    void removeAll() {
        BSTDictionary<String, SortableString> dictionary = new BSTDictionary<>();
        assertEquals(0, dictionary.depth());
        dictionary.insert(new SortableString("Janet"), "Janet");
        dictionary.insert(new SortableString("Bob"), "Bob");
        dictionary.insert(new SortableString("Alan"), "Alan");
        dictionary.insert(new SortableString("Ellen"), "Ellen");
        dictionary.insert(new SortableString("Tom"), "Tom");
        dictionary.insert(new SortableString("Karen"), "Karen");
        dictionary.insert(new SortableString("Wendy"), "Wendy");

        assertEquals(3, dictionary.depth());

        dictionary.insert(new SortableString("Zach"), "Zach");

        assertEquals(4, dictionary.depth());

        dictionary.insert(new SortableString("Zachary"), "Zachary");

        dictionary.delete(new SortableString("Janet"));

        assertEquals(5, dictionary.depth());

        dictionary.delete(new SortableString("Tom"));

        assertEquals(4, dictionary.depth());
        dictionary.delete(new SortableString("Zach"));
        dictionary.delete(new SortableString("Zachary"));
        dictionary.delete(new SortableString("Bob"));
        dictionary.delete(new SortableString("Alan"));
        dictionary.delete(new SortableString("Ellen"));
        dictionary.delete(new SortableString("Karen"));
        dictionary.delete(new SortableString("Wendy"));
        assertEquals(0, dictionary.depth());
    }

    @Test
    void CheckAllRemoveTypes() {
        BSTDictionary<String, SortableString> dictionary = new BSTDictionary<>();
        assertEquals(0, dictionary.depth());
        dictionary.insert(new SortableString("Janet"), "Janet");
        dictionary.insert(new SortableString("Bob"), "Bob");
        dictionary.insert(new SortableString("Alan"), "Alan");
        dictionary.insert(new SortableString("Ellen"), "Ellen");
        dictionary.insert(new SortableString("Tom"), "Tom");
        dictionary.insert(new SortableString("Nancy"), "Nancy");
        dictionary.insert(new SortableString("Wendy"), "Wendy");

        dictionary.delete(new SortableString("Alan"));
        assertEquals(dictionary.search(new SortableString("Alan")),null);
        dictionary.delete(new SortableString("Bob"));
        assertEquals(dictionary.search(new SortableString("Bob")),null);
        dictionary.delete(new SortableString("Janet"));
        assertEquals(dictionary.search(new SortableString("Bob")),null);
        assertEquals(3, dictionary.depth());
        dictionary.printTree();
    }

}
