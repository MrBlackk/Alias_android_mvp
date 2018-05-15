<img src="http://drive.google.com/uc?export=view&id=1dKFOEL0VW9yjW4SrMSKsG-HQtlrSPH0V" alt="Screens">
<img src="http://drive.google.com/uc?export=view&id=1Svv4do0a6khHIBfoDYXrsrgU8zlpq_IF" alt="UML">

**StartActivity** class - calling `presenter` methods
```java
public class StartActivity extends AppCompatActivity implements StartView {
  Button btnNewGame;
  private StartPresenter presenter;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
  ...
  presenter = new StartPresenterImpl(this);
  presenter.onStart();
  ...
  }
  
  @Override
  protected void runListeners() {
    btnNewGame.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            presenter.onNewGameButtonClick();
        }
    });
    ...
  }
  
  @Override
  public void onBackPressed() {
    presenter.onBackButtonPressed();
  }
}
```

**StartPresenterImpl** class - calling `startView` methods
```java
public class StartPresenterImpl implements StartPresenter {
  StartView startView;
  
  public StartPresenterImpl(StartView startView) {
    this.startView = startView;
    ...
  }
  
  @Override
  public void onStart() {
    if(!game.isStarted())
        startView.hideContinueButton();
  }
  
  @Override
  public void onNewGameButtonClick() {
    if(game.isStarted())
        startView.showContinueGameDialog();
    else
        startNewGame();
  }
  
  @Override
  public void onBackButtonPressed() {
    startView.showExitGameDialog();
  }
}
```
