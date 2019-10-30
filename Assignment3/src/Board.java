public class Board {
    String[] slots;

    public Board() {
        this.slots = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20" };
    }

    public void updateBoard(String slot, Card card) {
        int slotIndex = Integer.parseInt(slot) - 1;
        this.slots[slotIndex] = card.getTitle();
    }

    public boolean slotsAreFilled() {
        for (int index = 0; index < slots.length; index++) {
            String originalSlotName = Integer.toString(index + 1);
            if (slots[index].equals(originalSlotName) && index <= 15) {
                return false;
            }
        }
        return true;
    }
}
