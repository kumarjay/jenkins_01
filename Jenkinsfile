pipeline {
//None parameter in the agent section means that no global agent will be allocated for the entire Pipeline’s
//execution and that each stage directive must specify its own agent section.
    agent any //No global agent..every stage have their own agent
    stages {
        stage('Build') {
            when{
                expression{
                    env.BRANCH_NAME == "main" || BRANCH_NAME =='master'
                }
            }
            
            
            steps {
                echo "Hello World"
                //This sh step runs the Python command to compile your application and
                //its calc library into byte code files, which are placed into the sources workspace directory
                // sh "python -m py_compile sources/add2vals.py sources/calc.py"
                //This stash step saves the Python source code and compiled byte code files from the sources
                //workspace directory for use in later stages.
                //stash(name: "compiled-results", includes: "sources/*.py*")
            }
        }
        
        
    }
    post{
        always{
        echo "Always print message"
        }}
}
