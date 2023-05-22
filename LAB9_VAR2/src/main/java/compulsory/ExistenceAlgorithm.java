package compulsory;

import compulsory.entities.Album;
import compulsory.repositories.AlbumRepository;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.BoolVar;
import org.chocosolver.solver.variables.SetVar;

import java.util.List;
import java.util.stream.Collectors;

public class ExistenceAlgorithm {
    AlbumRepository albumRepository;
    Model model = new Model("Same letter problem");
    private int k; //k albums
    private int p; //not a bigger gap than p between years

    public ExistenceAlgorithm(int albumNumber, int gap) {
        albumRepository = new AlbumRepository();
        this.k = albumNumber;
        this.p = gap;
    }

    public List<Album> returnAlbum() {
        List<Album> albumList = returningAlphabet();
        return albumList;
    }

    public List<Album> returningAlphabet() {
        int i;
        for (i = 65; i <= 90; i++) {
            char letter = (char) i;
            String convertLetter = Character.toString(letter);
            List<Album> albumList = albumRepository.findByFirstLetter(convertLetter);
            if (checker(albumList)) {
                List<Album> albums = newList(albumList);
                SetVar b = model.setVar(albums == null ? 0 : 1);
                System.out.println("The result is " + b.getValue().toArray()[0]);
                if (albums != null) {
                    return albums;
                }
            }

        }
        return null;
    }

    private List<Album> sortingList(List<Album> albumList) {
        List<Album> sortedList = albumList
                .stream()
                .sorted((l1, l2) -> l1.getYear() - l2.getYear())
                .collect(Collectors.toList());
        return sortedList;
    }

    private List<Album> newList(List<Album> albumList) {
        List<Album> sortedList = sortingList(albumList);
        int j = albumList.size() - 1;
        while (sortedList.size() >= k) {
            int year_finish = sortedList.get(j).getYear();
            int year_start = sortedList.get(0).getYear();
            if (year_finish - year_start >= p) {
                if (year_finish - sortedList.get(j - 1).getYear() > sortedList.get(1).getYear() - year_start) {
                    sortedList.remove(j);
                } else {
                    sortedList.remove(0);
                }
                j--;
            } else {
                return sortedList;
            }
        }
        return null;
    }

    private boolean checker(List<Album> albumList) {
        if (albumList.size() < k) {
            return false;
        }
        return true;
    }
}
