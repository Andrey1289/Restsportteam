package org.andrey.sportteam.model;


import javax.persistence.*;
import javax.xml.crypto.Data;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "teamId")
    private Long teamId;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "name")
    private String name;
    @Column(name = "middleName")
    private String middleName;
    @Column(name = "birthDay")
    private Data birthDay;
    @Column(name = "role")
    private String role;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public Team getTeam() {
        return team;
    }


    public Player(Long id, Long teamId, String lastName, String name, String middleName, Data birthDay, String role) {
        this.id = id;
        this.teamId = teamId;
        this.lastName = lastName;
        this.name = name;
        this.middleName = middleName;
        this.birthDay = birthDay;
        this.role = role;
    }

    public Player() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Data getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Data birthDay) {
        this.birthDay = birthDay;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", teamId=" + teamId +
                ", lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthDay=" + birthDay +
                ", role='" + role + '\'' +
                '}';
    }
}
