public class EditPeopleSuggestion {
    private People people;
    private People changedPeople;

    public EditPeopleSuggestion(People people) {
        this.people = people;
    }

    public EditPeopleSuggestion(People people, People changedPeople) {
        this.people = people;
        this.changedPeople = changedPeople;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public People getChangedPeople() {
        return changedPeople;
    }

    public void setChangedPeople(People changedPeople) {
        this.changedPeople = changedPeople;
    }
}
