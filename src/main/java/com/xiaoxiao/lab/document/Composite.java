package com.xiaoxiao.lab.document;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    public List<Component> components;


    Composite() {
        components = new ArrayList<>();
    }


    public int composeCompositeFromLines(List<Line> lines, int level) {
        int i;
        for (i = 0; i < lines.size(); i++) {
            Line line = lines.get(i);
            if (line instanceof Head head) {
                if (head.getLevel() > level) {
                    components.add(head);
                    Composite composite = new Composite();
                    int index = composite.composeCompositeFromLines(lines.subList(i + 1, lines.size()), head.getLevel());
                    components.add(composite);
                    i += index;

                } else {
                    return i;
                }
            } else {
                components.add(line);
            }
        }
        return i;
    }


    @Override
    public void print(int prefix) {
        for (Component component : components) {
            component.print(prefix+4);
        }
    }



    public void checkAndPrint(String column) {
        for (Component component : components) {
            if (component instanceof Head head) {
                if (head.getText().equals(column)) {
                    head.print(0);
                    int index = components.indexOf(head);
                    if (components.get(index + 1) instanceof Composite composite) {
                        composite.print(0);
                    }
                }
            } else if (component instanceof Composite composite) {
                composite.checkAndPrint(column);
            }
        }
    }


}
