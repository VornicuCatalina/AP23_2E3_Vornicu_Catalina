package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlayerController {
    public List<Player> players;
    public PlayerController(){
        players = new ArrayList<>();
        players.add(new Player(1,"Sussy bot"));
    }
    public int indexPlayer(int id){
        for(Player p:players){
            if(p.getId() == id){
                return players.indexOf(p);
            }
        }
        return -1;
    }

    public Player getPlayer(int id){
        for(Player p:players){
            if(p.getId() == id)
                return p;
        }
        return null;
    }

    public void removePLayer(int idx){
        players.remove(idx);
    }
    @RequestMapping("/players")
    public List<Player> getPlayers(){
        return players;
    }

    @PostMapping("/new")
    public Player create(@RequestBody Player player){
        players.add(player);
        return player;
    }

    @PutMapping("/modify")
    public String modifyName(@RequestBody Player player){
        int id = player.getId();
        String newName = player.getName();
        Player helper = getPlayer(id);
        if(helper!=null){
            int idx = indexPlayer(id);
            players.get(idx).setName(newName);
            return "Name modified successfully";
        }
        else{
            return "Bad id";
        }
    }

    @DeleteMapping("/remove")
    public String deletePlayer(@RequestBody Player player){
        int id = player.getId();
        int idx = indexPlayer(id);
        if(idx <0){
            return "Bad id";
        }
        else{
            removePLayer(idx);
            return "Player was deleted";
        }
    }
}
