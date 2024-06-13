public class DoubleLinkedList10 {
    Kendaraan10 head;
    Kendaraan10 tail;
    int size;

    public DoubleLinkedList10() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(String noTNKB, String nama, String jenis, int cc, int tahun, int bulanHarusBayar) {
        Kendaraan10 newNode = new Kendaraan10(noTNKB, nama, jenis, cc, tahun, bulanHarusBayar);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(String noTNKB, String nama, String jenis, int cc, int tahun, int bulanHarusBayar) {
        if (isEmpty()) {
            addFirst(noTNKB, nama, jenis, cc, tahun, bulanHarusBayar);
        } else {
            Kendaraan10 newNode = new Kendaraan10(noTNKB, nama, jenis, cc, tahun, bulanHarusBayar);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
        }
    }

    public void add(String noTNKB, String nama, String jenis, int cc, int tahun, int bulanHarusBayar, int index)
            throws Exception {
        if (isEmpty()) {
            addFirst(noTNKB, nama, jenis, cc, tahun, bulanHarusBayar);
        } else if (index < 0 || index > size) {
            throw new Exception("Nilai indeks di luar batas");
        } else if (index == 0) {
            addFirst(noTNKB, nama, jenis, cc, tahun, bulanHarusBayar);
        } else if (index == size) {
            addLast(noTNKB, nama, jenis, cc, tahun, bulanHarusBayar);
        } else {
            Kendaraan10 current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            Kendaraan10 newNode = new Kendaraan10(noTNKB, nama, jenis, cc, tahun, bulanHarusBayar);
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public void print() {
        if (!isEmpty()) {
            Kendaraan10 tmp = head;
            System.out.println("NoTNKB\tNama\tJenis\tCC\tTahun\tBulanHarusBayar");
            while (tmp != null) {
                System.out.printf("%s\t%s\t%s\t%d\t%d\t%d\n", tmp.noTNKB, tmp.nama, tmp.jenis, tmp.cc, tmp.tahun,
                        tmp.bulanHarusBayar);
                tmp = tmp.next;
            }
            System.out.println("berhasil diisi");
        } else {
            System.out.println("Linked List Kosong");
        }
    }

    public void removeFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List masih kosong, tidak dapat dihapus!");
        } else if (size == 1) {
            clear();
        } else {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void removeLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List masih kosong, tidak dapat dihapus!");
        } else if (size == 1) {
            clear();
        } else {
            tail = tail.prev;
            tail.next = null;
            size--;
        }
    }

    public void remove(int index) throws Exception {
        if (isEmpty() || index >= size || index < 0) {
            throw new Exception("Nilai indeks di luar batas");
        } else if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Kendaraan10 current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
        }
    }

    public Kendaraan10 getFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List kosong");
        }
        return head;
    }

    public Kendaraan10 getLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List kosong");
        }
        return tail;
    }

    public Kendaraan10 get(int index) throws Exception {
        if (isEmpty() || index >= size || index < 0) {
            throw new Exception("Nilai indeks di luar batas.");
        }
        Kendaraan10 current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public Kendaraan10 findByNoTNKB(String noTNKB) {
        if (!isEmpty()) {
            Kendaraan10 tmp = head;
            while (tmp != null) {
                if (tmp.noTNKB.equals(noTNKB)) {
                    return tmp;
                }
                tmp = tmp.next;
            }
        }
        return null;
    }
}
