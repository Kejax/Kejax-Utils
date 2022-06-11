package kejax.languages;

public enum DE_de implements BaseLanguage{

    JOIN_MESSAGE("%player% ist dem Spiel beigetreten (%player_count% / %max_players%)", VariableTypes.PSM),
    LEAVE_MESSAGE("%player% hat das Spiel verlassen (%player_count% / %max_players%)", VariableTypes.PSM),
    NO_PERMISSION_MESSAGE("Dazu hast du keine Berechtigung %player%", VariableTypes.PSM);

    private String message;
    private String type;

    DE_de(String message, String type) {
        this.message = message;
        this.type = type;

    }

    @Override
    public String get_message() {
        return this.message;
    }
}
