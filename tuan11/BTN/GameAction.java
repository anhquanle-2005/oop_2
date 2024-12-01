package tuan11.BTN;

import java.util.ArrayList;

public class GameAction {
    private ArrayList<Game> games;

    public GameAction() {
        this.games = new ArrayList<>();
    }

    // Thêm game
    public void addGame(Game game) {
        games.add(game);
        System.out.println("Game đã được thêm thành công.");
    }

    // Hiển thị danh sách game
    public void displayGames() {
        if (games.isEmpty()) {
            System.out.println("Không có game nào.");
        } else {
            for (Game game : games) {
                System.out.println(game);
            }
        }
    }


    public void deleteGame(int id) {
        Game gameToRemove = null;
        for (Game game : games) {
            if (game.getId() == id) {
                gameToRemove = game;
                break;
            }
        }
        if (gameToRemove != null) {
            games.remove(gameToRemove);
            System.out.println("Game đã được xóa thành công.");
        } else {
            System.out.println("Không tìm thấy game với ID này.");
        }
    }

    public void updateGame(int id, String name, String genre, double pricePerHour) {
        for (Game game : games) {
            if (game.getId() == id) {
                game = new Game(id, name, genre, pricePerHour);
                System.out.println("Game đã được cập nhật thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy game với ID này.");
    }
}
