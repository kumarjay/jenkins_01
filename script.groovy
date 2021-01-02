def defFunc(){
  echo "This is groovey ${params.VERSION}"
}
def defBuild(){
  //sh "docker run exec -p 5000:5000 abc/xyz4"
  echo "This is inside build with version ${params.VERSION1}"
}

return this
