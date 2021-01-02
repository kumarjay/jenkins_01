def gv

pipeline {
//None parameter in the agent section means that no global agent will be allocated for the entire Pipeline’s
//execution and that each stage directive must specify its own agent section.
    agent any //No global agent..every stage have their own agent
    environment{
        NEW_VERSION= '1.3.0'
    }
    parameters{
        string(name: "VERSION", defaultValue: "", description: "this is parameter")
        choice(name: "VERSION1", choices: ['1,1', '1.2', '1.3'], description: "this is choice")
        booleanParam(name: "executeText", defaultValue: true, description: "this is boolean")
    }
    
    stages {
        stage('init'){
            steps{
                script{
                    gv= load "script.groovy"
                }
            }
        }
        stage('Build') {
            agent{
                docker {
                    //This image parameter (of the agent section’s docker parameter) downloads the python:2-alpine
                    //Docker image and runs this image as a separate container. The Python container becomes
                    //the agent that Jenkins uses to run the Build stage of your Pipeline project.
                    image 'abc/xyz4'
                    image "python:3"
                }
            }
            when{
                expression{
                    env.BRANCH_NAME == "main" || env.GIT_BRANCH =='origin/main'
                }
            }
                        
            steps {
                echo "Hello World.....||| develope"
                echo "version ${NEW_VERSION}"
                echo "parameter is ${VERSION}"
                
                script{
                gv.defBuild()
                    
                sudo "worked...???"
                //This stash step saves the Python source code and compiled byte code files from the sources
                //workspace directory for use in later stages.
                stash(name: 'compiled-results', includes: 'sources/*.py*')
                }
                //This sh step runs the Python command to compile your application and
                //its calc library into byte code files, which are placed into the sources workspace directory
                // sh "python -m py_compile sources/add2vals.py sources/calc.py"
                //This stash step saves the Python source code and compiled byte code files from the sources
                //workspace directory for use in later stages.
                //stash(name: "compiled-results", includes: "sources/*.py*")
            }
        }
        stage('test'){
            when{
                expression{
                    params.executeText
                }
            }
            steps{
                echo "testing the application"
                script{
                gv.defFunc()
                }
            }
        }
        
    }
    
    
        
    post{
        always{
            echo "Always print message ${env.GIT_BRANCH}"
            echo "current branch ${env.BRANCH_NAME}"
        }}
}
