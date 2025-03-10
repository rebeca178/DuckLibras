import lombok.getter;
import lombok.setter;

@getter
@setter

@Entity
@table(name='aluno')
public class userEnnity implements Serializable {
    private static final long serialversionuid=

    @id
    @Generatedvalue ( strategy = generationType.identity)
    @column(name="id")
    private long id;
    private string name;

    @column(name = "pass",columnDefinition ="text")
    private string pass;

    @column(name = "status",columnDefinition ="boolean")
    private string status;




}
    
}
