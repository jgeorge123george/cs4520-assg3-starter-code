1. MVP
  Model-View-Presenter pattern is defined in MVPContractInterface and implemented in
        MVPModel: MVPContractInterface.Model (MODEL) 
          Implements the methods to perform the actual calculations using the values from the presenter.
      MVPFragment: Fragment(), MVPContractInterface.View  (VIEW)
          Implements steInputOne, setInputTwo, setResult, show error, clearInputs
      MVPPresenter(private val context: Context,_view: MVPContractInterface.View): MVPContractInterface. (Presenter)
          Receives events from View and invokes methods in Model
2. MVVM
      Model-View-ViewModel pattern, 
         The model layer is implemented by 'Calculation'
         The view layer is implemented in MVVMFragment, this fragment is responsible for presenting the UI to the user
         ViewModel - CalculatorViewModel class which extends 'ViewModel', this class is an intermediary between the view and the model
