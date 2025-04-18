name: Java CI with Maven
on:
  push:
    branches: [ main ]
  pull_request:
    branches: [ main ]
jobs:
  build:
    runs-on: ubuntu-latest
    steps:
    - name: Checkout repository
      uses: actions/checkout@v4
    - name: Set up JDK 11
      uses: actions/setup-java@v4
      with:
        java-version: '11'
        distribution: 'temurin'
    - name: Cache Maven packages
      uses: actions/cache@v4
      with:
        path: ~/.m2/repository
        key: ${{ runner.os }}-maven-${{ hashFiles('**/pom.xml') }}
        restore-keys: ${{ runner.os }}-maven
    - name: Install dependencies
      run: mvn install -DskipTests

    - name: Set up ChromeDriver
      uses: nanasess/setup-chromedriver@v2
      with:
        chromedriver-version: 'latest'

    - name: Run specific test
      run: mvn test -Dtest=E2E_Testcases.TC292_P0_E2E_CreateColors_Solid
