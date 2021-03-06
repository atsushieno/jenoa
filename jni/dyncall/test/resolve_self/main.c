#include "../../dynload/dynload.h"
#include "../../dyncall/dyncall_macros.h"
#include <assert.h>

#ifdef DC_WINDOWS
#define DLL_EXPORT __declspec( dllexport )
#else
#define DLL_EXPORT
#endif

DLL_EXPORT double add_dd_d(double x, double y);

double add_dd_d(double x, double y) 
{
  return x+y;
}

int main(int argc, char* argv[])
{
  void* address;
  double result;
  DLLib* pLib = dlLoadLibrary(NULL);
  assert(pLib);

  address = dlFindSymbol(pLib, "add_dd_d");
  assert(address);
  result = ( (double (*) (double,double) ) address ) (20.0, 3.0);
  assert(result == 23);
  return 0;
}
